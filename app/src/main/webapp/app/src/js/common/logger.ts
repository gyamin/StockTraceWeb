/// <reference path="./../common/config.ts"/>
namespace Common {

    // Log level list
    export enum LogLevel {
        debug,
        info,
        warning,
        error
    }

    export class Logger {

        debug(message: string) :void {
            var logLevel = Common.Config.LOG_LEVEL;
            if(logLevel >= LogLevel.debug) {
                console.log(message);
            }
        }

        info(message: string) :void {
            var logLevel = Common.Config.LOG_LEVEL;
            if(logLevel >= LogLevel.info) {
                console.log(message);
            }
        }

        warning(message: string) :void {
            var logLevel = Common.Config.LOG_LEVEL;
            if(logLevel >= LogLevel.warning) {
                console.log(message);
            }
        }

        error(message: string) :void {
            var logLevel = Common.Config.LOG_LEVEL;
            if(logLevel >= LogLevel.error) {
                console.log(message);
            }
        }
    }
}
