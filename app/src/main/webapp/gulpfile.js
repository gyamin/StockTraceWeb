'use strict';

const gulp = require('gulp');
const sass = require('gulp-sass');
const babel = require('gulp-babel');

var define = {
  sass:
    {
      path: './assets/sass/**/*.scss',
      dest: './resources/css/'
    },
  javascript:
  {
    path: './assets/javascript/**/*.js',
    dest: './resources/javascript/'
  }
}

// scssコンパイル/デプロイ
gulp.task('sass', function () {
  gulp.src(define.sass.path)
    .pipe(sass.sync().on('error', sass.logError))
    .pipe(gulp.dest(define.sass.dest));
});

// javascriptデプロイ
gulp.task('javascript', function () {
  gulp.src(define.javascript.path)
      .pipe(babel({presets: ['es2015']}))
      .pipe(gulp.dest(define.javascript.dest));
});

gulp.task('watch', function () {
  gulp.watch(define.sass.path, ['sass']);
  gulp.watch(define.javascript.path, ['javascript']);
});

// The default task (called when you run `gulp` from cli)
gulp.task('default', ['sass', 'javascript']);
