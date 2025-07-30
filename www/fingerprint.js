var exec = require('cordova/exec');

var fingerprint = {
    autenticar: function(success, error) {
        exec(success, error, "FingerprintPlugin", "autenticar", []);
    }
};

module.exports = fingerprint;