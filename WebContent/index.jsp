<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title><s:text name="app.title"></s:text></title>
  </head>
  <body>
    <div class="header">
      <h1><s:text name="app.title"></s:text></h1>
    </div>
    <div class="wrapper">
      <p><s:text name="login.message"></s:text></p>
      <s:actionerror />
      <s:form action="loginVendedor">
        <label for="vendedor.nombre"><s:text name="form.vendedor.usuario" /></label>
        <s:textfield id="vendedor.nombre" name="vendedor.nombre" />
        <label for="vendedor.password"><s:text name="form.vendedor.password" /></label>
        <s:password id="vendedor.password" name="vendedor.password" />
        <s:submit value="Log in"/>
      </s:form>
    </div>
  </body>
</html>
