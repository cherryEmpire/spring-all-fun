/**
 * 加载主页
 */
let promise = getJson("/root", null);
promise.then((jsonData) => {
    let p = document.getElementById("FILE_LIST");
    let obj = {
        treeJson: jsonData,
        pDom: p,
    };
    var tree = new Tree(obj);
})
