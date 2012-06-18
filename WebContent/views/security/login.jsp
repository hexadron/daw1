<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="utf-8">
    <title>Iniciar Sesión</title>
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le HTML5 shim, for IE6-8 support of HTML elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/css/main.css" rel="stylesheet">

    <!-- Le fav icons -->
    <link rel="shortcut icon" href="/assets/images/favicon.ico">
  </head>

  <body>

    <div class="topbar">
      <div class="topbar-inner">
        <div class="container-fluid">
          <a class="brand" href="..">Atenci&oacute;n de Requerimientos</a>
        </div>
      </div>
    </div>

    <div class="container-fluid">
      
      <div class="content">
        <div class="page-header">
          <h1>Iniciar Sesión</h1>
        </div>
        <form>
          <fieldset>
            <div class="clearfix">
              <label for="movimiento">Usuario</label>
              <div class="input">
                <input type="text" class="xlarge">
              </div>
            </div>
            <div class="clearfix">
              <label for="movimiento">Contraseña</label>
              <div class="input">
                <input type="text" class="xlarge">
              </div>
            </div>
          <div class="actions">
            <input type="submit" class="btn primary" value="Ingresar" data-backdrop="static">&nbsp;<button type="reset" class="btn">Limpiar</button>
          </div>
          </fieldset>
        </form>
        <div id="pop-modal"></div>
        <div id="pop-over"></div>
      </div>
    </div>
    <script type="text/javascript" src="assets/js/jquery.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap-modal.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap-twipsy.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap-popover.js"></script>
    <script type="text/javascript" src="assets/js/nota.js"></script>
  </body>
</html>