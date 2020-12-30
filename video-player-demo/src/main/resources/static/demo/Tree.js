/**
 * 树形控件 传入一个文件信息数组，创建一个树形文件列表
 *
 * 构造参数如下：
 * @param {Object} args 构造参数
 * @param {String} args.treeJson 文件信息数组，是一个json格式，包含多个文件信息
 * @param {Object} args.pDom 树的位置
 *      treeJson格式如下 ：
 *        {
 *         [{},{},{},]
 * 		}
 * @param {Function()} args.onclick 点击事件
 */
class Tree {
    /**
     *  dom 结构
     *          <div>
     *              <ul>
     *                  <li>
     *                      <div>
     *                             <span>icon</span>
     *                             <span>name</span>
     *                             <span>size</span>
     *                             <span>time</span>
     *                      </div>
     *                  </li>
     *                  <li>
     *                      <div>
     *                             <span></span>
     *                             <span></span>
     *                             <span></span>
     *                             <span></span>
     *                      </div>
     *                  </li>
     *              </ul>
     *          </div>
     *
     */
    constructor(args) {
        this._init();
        if (args.pDom !== undefined) {
            args.pDom.appendChild(this.pDom);
        }
        let m = new Map();
        this.mapList = m;
        for (let i = 0, len = args.treeJson.length; i < len; i++) {
            let elem_ul = this.pDom.firstChild;
            this._createNode(args.treeJson[i], elem_ul);
        }
        //将点击事件绑定在树的根节点上
        this.pDom.onclick = this.onclick.bind(this);
    }

    /**
     * 初始化树，创建树的根节点mydiv，以及表头
     */
    _init() {
        let elem_div = document.createElement("div");
        elem_div.id = "mydiv";
        let elem_ul = document.createElement("ul");
        elem_ul.id = "myul";
        let elem_li = document.createElement("li");
        let elem_li_div = document.createElement("div");
        elem_li_div.className = "div-system";
        let elem_sp1 = document.createElement("span");
        let elem_sp2 = document.createElement("span");
        elem_sp2.innerText = "名称";
        let elem_sp3 = document.createElement("span");
        elem_sp3.innerText = "大小";
        let elem_sp4 = document.createElement("span");
        elem_sp4.innerText = "修改日期";
        elem_sp1.className = "span-icon-system";
        elem_sp2.className = "span-name";
        elem_sp3.className = "span-size";
        elem_sp4.className = "span-time";
        elem_li_div.appendChild(elem_sp1);
        elem_li_div.appendChild(elem_sp2);
        elem_li_div.appendChild(elem_sp3);
        elem_li_div.appendChild(elem_sp4);
        elem_li.appendChild(elem_li_div);
        elem_ul.appendChild(elem_li);
        elem_div.appendChild(elem_ul);
        //树的根节点
        this.pDom = elem_div;
    }

    /**
     * 通过节点对象中信息以及dom父节点，创建节点
     * @param {Object} node 文件信息，一个json格式数据，包含文件类型，文件名，文件大小，文件路径，文件最后修改时间
     * @param {Object} pNode 父节点
     */
    _createNode(node, pNode) {
        let elem_li = document.createElement("li");
        elem_li.className = "li-node";
        let elem_li_div = document.createElement("div");
        elem_li_div.className = "div-node";
        elem_li_div.id = getRandomId(16);
        let elem_sp1 = document.createElement("span");
        if (node.fileType == "DIR") {
            elem_sp1.className = "span-icon-dirClose";
        } else {
            elem_sp1.className = "span-icon-file";
        }
        let elem_sp2 = document.createElement("span");
        // let elem_sp3 = document.createElement("span");
        // let elem_sp4 = document.createElement("span");
        elem_sp2.className = "span-name";
        // elem_sp3.className = "span-size";
        // elem_sp4.className = "span-time";
        elem_sp2.innerText = node.fileName;
        // elem_sp3.innerText = getFileSize(node.fileSize);
        // elem_sp4.innerText = getLastModify(node.fileLastModify);
        elem_li_div.appendChild(elem_sp1);
        elem_li_div.appendChild(elem_sp2);
        // elem_li_div.appendChild(elem_sp3);
        // elem_li_div.appendChild(elem_sp4);
        elem_li.appendChild(elem_li_div);
        let map = new Map();
        //节点信息
        map.nodeInfo = node;
        //是否打开状态
        map.isOpen = false;
        //是否加载过
        map.alreadyLoad = false;
        this.mapList.set(elem_li_div.id, map);
        pNode.appendChild(elem_li);
    }

    /**
     * 点击事件，通过点击的target，执行相应的事件，
     * 如果点击目录 展开收缩（如果目录为第一次展开，发送ajax请求，接收json，创建节点，若不是，执行展开收缩事件），
     * 点击文件下载 (发送下载请求)。
     * @param {Object} event
     */
    onclick(event) {
        let target = event.target || event.srcElement;
        let clName = target.className;
        let p;
        if (clName === "div-node") {//用class
            p = target;
        } else if (clName === "span-icon-dirClose" || clName === "span-icon-dirOpen" || clName === "span-icon-file" || clName === "span-name" || clName === "span-size" || clName === "span-time") {
            p = target.parentNode;
        }
        if (p === undefined) {
            return;
        }
        let pid = p.id;
        let l = this.mapList.get(pid);
        if (l.nodeInfo.fileType === "DIR") {
            if (l.alreadyLoad) {
                if (l.isOpen) {
                    //收缩
                    p.firstChild.className = "span-icon-dirClose";
                    if (p.parentNode.lastChild.className !== "div-node") {
                        p.parentNode.lastChild.style.display = "none";
                    }
                    this.mapList.get(pid).isOpen = false;
                } else {
                    //展开
                    p.firstChild.className = "span-icon-dirOpen";
                    p.parentNode.lastChild.style.display = "";
                    this.mapList.get(pid).isOpen = true;
                }
            } else {
                p.firstChild.className = "span-icon-dirOpen";
                //send ajax 添加节点
                let promise = getJson("project", l.nodeInfo.filePath);
                promise.then((jsonData) => {
                    let elem_ul = document.createElement("ul");
                    for (let i = 0, len = jsonData.length; i < len; i++) {
                        this._createNode(jsonData[i], elem_ul);
                    }
                    p.parentNode.appendChild(elem_ul);
                });
                this.mapList.get(pid).alreadyLoad = true;
                this.mapList.get(pid).isOpen = true;
            }
        } else if (l.nodeInfo.fileType === "FILE") {
            let path = l.nodeInfo.filePath.substring(8);
            let pathCode = btoa(encodeURIComponent(path));

            let p = document.getElementById('VIDEO_LIST');
            let elementById = document.getElementById('video_player_p');
            if (elementById != null) {
                elementById.remove();
            }
            let div = document.createElement('div');
            div.id = 'video_player_p';
            p.append(div);
            let htmlHeadingElement = document.createElement('h2');
            htmlHeadingElement.innerText = l.nodeInfo.fileName;
            let htmlVideoElement = document.createElement('video');
            htmlVideoElement.id = 'video_player';
            htmlVideoElement.setAttribute("controls", "controls");
            htmlVideoElement.setAttribute("controlslist", "nodownload");
            div.appendChild(htmlHeadingElement);
            div.appendChild(htmlVideoElement);
            let htmlSourceElement = document.createElement('source');
            htmlSourceElement.id = 'my_video';
            htmlSourceElement.src = "http://192.168.1.7:8084/video/play/" + pathCode;
            htmlSourceElement.type = "video/mp4";
            htmlVideoElement.appendChild(htmlSourceElement);
            p.appendChild(div);
        }
    }
}
