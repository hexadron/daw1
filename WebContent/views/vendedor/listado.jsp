<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title><s:text name="app.title"></s:text></title>
		<link href="assets/stylesheets/screen.css" rel="stylesheet">
	<head>
	<body>
		<h2><s:text name="form.vendedor.listado.titulo"></s:text></h2>
		<%-- <s:form action="buscarVendedores">
			<s:text name="formulario.campo.nombre"/> <s:textfield name="vendedor.nombre"/>
			<s:submit value="Buscar"/>
		</s:form>

		<!-- link para registro -->
		<s:a action="nuevo">
			<s:text name="formulario.boton.nuevo"/>
		</s:a>
 --%>
		<s:actionmessage />

		<s:if test="vendedores.size > 0">
			<table class="tabla">
				<thead>
					<tr>
						<th><s:text name="form.vendedor.codigo"></s:text></th>
						<th><s:text name="form.vendedor.nombre"></s:text></th>
						<th><s:text name="form.vendedor.apellido"></s:text></th>
						<th><s:text name="form.vendedor.actualizar"></s:text></th>
						<th><s:text name="form.vendedor.eliminar"></s:text></th>
						<th><s:text name="form.vendedor.detalle"></s:text></th>
					</tr>
				</thead>
				<s:iterator value="vendedores">	
					<tr>
						<td><s:property value="id" /></td>
						<td><s:property value="nombre" /></td>
						<td><s:property value="apellido" /></td>
						<td>
							<s:url action="cargarVendedor" id="actualizar">
								<s:param name="codigo">
									<s:property value="id" />
								</s:param>
							</s:url>
							<s:a href="%{actualizar}"><s:text name="form.vendedor.actualizar"></s:text></s:a>
						</td>
						<td>
							<s:url action="eliminarVendedor" id="eliminar">
								<s:param name="codigo">
									<s:property value="id" />
								</s:param>
							</s:url>
							<s:a href="%{eliminar}"><s:text name="form.vendedor.eliminar"></s:text></s:a>
						</td>
						<td>
							<s:url action="detalleVendedor" id="detalle">
								<s:param name="codigo">
									<s:property value="id" />
								</s:param>
							</s:url>
							<s:a href="%{detalle}"><s:text name="form.vendedor.detalle"></s:text></s:a>     
						</td>
					</tr>
				</s:iterator>
			</table>
		</s:if>
	</body>
</html>
