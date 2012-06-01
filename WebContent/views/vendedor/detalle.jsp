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
    <s:text name="form.vendedor.detalle.titulo"></s:text>
  </h1>
  <ul>
    <li>
      <label for="vendedor.id"><s:text name="form.vendedor.codigo" /></label>
      <s:property value="vendedor.id" />
    </li>
    <li>
      <label for="vendedor.id"><s:text name="form.vendedor.nombre" /></label>
      <s:property value="vendedor.nombre" />
    </li>
    <li>
      <label for="vendedor.id"><s:text name="form.vendedor.apellido" /></label>
      <s:property value="vendedor.apellido" />
    </li>
    <li>
      <label for="vendedor.id"><s:text name="form.vendedor.fechaNacimiento" /></label>
      <s:property value="vendedor.fechaNacimiento" />
    </li>
    <li>
      <label for="vendedor.id"><s:text name="form.vendedor.edad" /></label>
      <s:property value="vendedor.edad" />
    </li>
    <li>
      <label for="vendedor.id"><s:text name="form.vendedor.estadoCivil" /></label>
      <s:property value="vendedor.estadoCivil.descripcion" />
    </li>
    <li>
      <label for="vendedor.id"><s:text name="form.vendedor.distrito" /></label>
      <s:property value="vendedor.distrito.descripcion" />
    </li>
  </ul>
  <s:url id="listado" action="listadoVendedor"></s:url>
  <s:a href="%{listado}"><s:text name="link.listado.volver"></s:text></s:a>
</body>
</html>

