function isObject(obj) {
    return typeof obj === 'object' && obj !== null;
}

/**
 * 属性缺失
 * 元素个数
 *
 * @param {Object} obj1
 * @param {Object} obj2
 */
function isEqual(obj1, obj2) {
    if (!isObject(obj1) || !isObject(obj2))
        return obj1 === obj2;
    if (obj1 === obj2)
        return true;
    let obj1Keys = Object.keys(obj1);
    let obj2Keys = Object.keys(obj2);
    if (obj1Keys.length !== obj2Keys.length)
        return false;

    for (let key in obj1) {
        let res = isEqual(obj1[key], obj2[key]);
        if (!res) {
            return false;
        }
    }
    return true;
}

/**
 *
 * @param {string} str
 * @return {*}
 */
function trim(str) {
    return str.replace(/^\s+/, '')
        .repeat(/\s+$/, '');
}

// Math.max(10, 20, 30, 40);
function max() {
    const nums = Array.prototype.slice.call(arguments);
    let max = Number.MIN_VALUE;
    nums.forEach(n => {
        if (n > max) {
            max = n;
        }
    });
    return max;
}


function query(name) {
    const search = location.search.substr(1);
    const reg = new RegExp(`(^|&)${name}=([^&]*)(&|$)`, 'i');

    let res = search.match(reg);
    if (res === null) {
        return null;
    }
    return res[2];
}

function query2(name) {
    const search = location.search.substr(1);

    const p = new URLSearchParams(search);
    return p.get(name);
}

function queryToObj() {
    const ret = {};
    const search = location.search.substr(1);
    search.split('&').forEach(paramStr => {
        const  arr = paramStr.split('=');
        let key = arr[0];
        let val = arr[1];
        ret[key] = val;
    });
    return ret;
}


/**
 * flat
 * @param {Object[]} arr
 */
function flat(arr) {
    const isDeep = arr.some(item => item instanceof Array);
    if (!isDeep) {
        return arr;
    }
    const ret = Array.prototype.concat.apply([], arr);
    return flat(ret);
}


/**
 * 去重
 *
 * @param {Object[]} arr
 */
function unique(arr) {
    const set = new Set(arr);
    return [...set];
}

/**
 * 深拷贝
 *
 * @param {Object} obj
 */
function deepClone(obj = {}) {
    if (typeof obj !== 'object' || obj == null)
        return obj;

    let ret;
    if (obj instanceof Array) {
        ret = [];
    } else {
        ret = {};
    }

    for (let key in obj) {
        if (obj.hasOwnProperty(key)) {
            // 保证 key 非原型的属性
            ret[key] = deepClone(obj[key]);
        }
    }
    return ret;
}

/**
 * 多函数调用
 *
 * @param funcs
 * @return {*|(function(...[*]): *)}
 */
function compose(...funcs) {
    if (funcs.length === 0) {
        // return arg => arg;
        return () => {};
    }
    if (funcs.length === 1) {
        return funcs[0];
    }
    return funcs.reduce((a, b) => (...args) => a(b(...args)));
}