let promise = getJson("/root", null);
promise.then((jsonData) => {
    let createNode = (item) => {
        let isLeaf = false;
        if (item.fileType == 'FILE') {
            isLeaf = true;
        }
        return {
            label: item.fileName,
            json: item,
            children: [],
            isLeaf: isLeaf
        }
    }
    let dataResult = [];
    for (let i = 0, len = jsonData.length; i < len; i++) {
        dataResult.push(createNode(jsonData[i]));
    }

    var Main = {
        data() {
            return {
                data: dataResult,
                defaultProps: {
                    children: 'children',
                    label: 'label'
                },

            };
        },
        methods: {
            handleNodeClick(data) {
                console.log(data);
            }
        }
    };
    var Ctor = Vue.extend(Main)
    new Ctor().$mount('#app')
});
