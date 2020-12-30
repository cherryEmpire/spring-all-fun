/**
 * 发送get请求方式的Ajax
 * @param {String} url 请求路径
 */
function getJson(url, path) {
    return new Promise((resolve, reject) => {
        var xhr = new XMLHttpRequest();
        xhr.open('GET', url, true);
        if (path != null) {
            xhr.setRequestHeader("PATH", path);
        }
        xhr.onreadystatechange = function () {
            if (this.readyState === 4) {
                //限制响应最长时间
                if (this.status === 200) {
                    resolve(JSON.parse(this.responseText));
                } else {
                    var resJson = {code: this.status, response: this.response}
                    reject(resJson);
                }
            }
        }
        xhr.send();
    });
}

/**
 * 发送post请求方式的Ajax
 * @param {String} url 请求路径
 * @param {String} data 请求正文
 */
function postJson(url, data) {
    return new Promise((resolve, reject) => {
        var xhr = new XMLHttpRequest();
        xhr.open("POST", url, true)
        xhr.onreadystatechange = function () {
            if (this.readyState === 4) {
                if (this.status === 200) {
                    resolve(JSON.parse(this.responseText), this);
                } else {
                    var resJson = {code: this.status, response: this.response}
                    reject(resJson, this);
                }
            }
        }
        xhr.send(JSON.stringify(data));
    })
}