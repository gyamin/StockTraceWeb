'use strict'
var App = App || {};

class Hoge {
    constructor(height, width) {
        this.name = 'Polygon';
        this.height = height;
        this.width = width;
        console.log("my height" + this.height);
        console.log("my width" + this.width);
    }
}

new Hoge(100, 200);
