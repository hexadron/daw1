<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<title>Bienvenido</title>
	</head>
	<body>
		<h1><s:text name="inicio.principal"></s:text> </h1>
		<p><s:text name="inicio.bienvenida"></s:text></p>

		<ul>
			<li><s:text name="inicio.ingresar"/></li>
		</ul>
		
		<s:url id="idiomaEn" action="idioma">
			<s:param name="request_locale">en</s:param>
		</s:url>	
		<s:url id="idiomaEs" action="idioma">
			<s:param name="request_locale">es</s:param>
		</s:url>
		
		
		<table style="width:780px; border=none" cellpadding="0" cellspacing="1">
			<tr align="left">
				<td>
					<s:a href="%{idiomaEn}"><s:text name="inicio.idioma.ingles"></s:text></s:a>
					<s:a href="%{idiomaEs}"><s:text name="inicio.idioma.espanol"></s:text></s:a>
				</td>
			</tr>
		</table>
	</body>
</html>
