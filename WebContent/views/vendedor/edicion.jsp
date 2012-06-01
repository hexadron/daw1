<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title><s:text name="app.title"></s:text></title>
<link href="assets/stylesheets/screen.css" rel="stylesheet">
<head>
<body>
  <h1>
    <s:text name="form.vendedor.edicion.titulo"></s:text>
  </h1>
  <s:form action="actualizarVendedor" method="post" name="formEdit">
    <ul>
      <li><s:hidden name="vendedor.id"></s:hidden></li>
      <li><label for="vendedor.nombre"><s:text name="form.vendedor.nombre" /></label>
          <s:textfield name="vendedor.nombre" /></li>
      <li><label for="vendedor.apellido"><s:text name="form.vendedor.apellido" /></label>
          <s:textfield name="vendedor.apellido" /></li>
      <li><label for="vendedor.fechaNacimiento"><s:text name="form.vendedor.fechaNacimiento" /></label>
          <s:textfield name="vendedor.fechaNacimiento" /></li>
      <li><label for="vendedor.edad"><s:text name="form.vendedor.edad" /></label>
          <s:textfield name="vendedor.edad" /></li>
      <li><label for="estadoCivil.id"><s:text name="form.vendedor.estadoCivil" /></label>
          <s:select name="estadoCivil.id" 
                    list="#application.estadosCiviles"
                    listKey="id"
                    listValue="descripcion"
                    value="%{ vendedor.estadoCivil.id }"
          /></li>
      <li><label for="distrito.id"><s:text name="form.vendedor.distrito" /></label>
          <s:select name="distrito.id" 
                    list="#application.distritos"
                    listKey="id"
                    listValue="descripcion"
                    value="%{ vendedor.distrito.id }"
          /></li>
      <li><s:submit value="%{ getText('form.boton.grabar') }"></s:submit></li>
    </ul>
  </s:form>
  <s:url id="listado" action="listadoVendedor"></s:url>
  <s:a href="%{listado}">
    <s:text name="link.listado.volver"></s:text>
  </s:a>
</body>
</html>
