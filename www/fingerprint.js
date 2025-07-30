var exec = require('cordova/exec');

var FingerprintPlugin = {
  autenticar: function (successCallback, errorCallback) {
    exec(
      function (result) {
        // Convierte el resultado JSON de string a objeto si es necesario
        if (typeof result === "string") {
          try {
            result = JSON.parse(result);
          } catch (e) {
            return errorCallback("Error al parsear respuesta: " + e.message);
          }
        }

        successCallback(result);
      },
      function (err) {
        errorCallback("Autenticación fallida: " + err);
      },
      "FingerprintPlugin",
      "autenticar",
      []
    );
  }
};

module.exports = FingerprintPlugin;
