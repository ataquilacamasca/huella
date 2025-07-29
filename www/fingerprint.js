var exec = require('cordova/exec');
var FingerprintPlugin = {
  autenticar: function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, "FingerprintPlugin", "autenticar", []);
  }
};
module.exports = FingerprintPlugin;