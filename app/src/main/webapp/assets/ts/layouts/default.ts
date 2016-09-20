'use strict'

class Hoge {
    name: string
    height: number
    width: number

    constructor(height, width) {
        this.name = 'Polygon';
        this.height = height;
        this.width = width;
        console.log("my height" + this.height);
        console.log("my width" + this.width);
    }
}

let hoge = new Hoge(100, 200);