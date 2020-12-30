/**
 * 将文件最后修改时间格式化
 */
function getLastModify(fileLastModify) {
    let date = new Date();
    date.setTime(fileLastModify);
    return date.toLocaleDateString() + date.toLocaleTimeString();
}

/**
 * 将文件大小格式化
 */
function getFileSize(fileSize) {
    if (fileSize === undefined)
        return "";
    let size = parseInt(fileSize);
    if (size === 0)
        return '0 B';
    let k = 1024,
        sizes = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'], i = Math.floor(Math.log(fileSize) / Math.log(k));
    return (fileSize / Math.pow(k, i)).toPrecision(3) + sizes[i];
}

/**
 * 生成随机唯一ID
 * @param {number} randomLength id长度
 */
function getRandomId(randomLength) {
    return Number(Math.random().toString().substr(3, randomLength) + Date.now()).toString(36);
}
