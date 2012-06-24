<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
    
<div class="topbar">
  <div class="topbar-inner">
    <div class="container-fluid">
      <a class="brand" href="/daw1">Atención de Requerimientos</a>
    </div>
  </div>
</div>

<div class="container-fluid">
  <div class="content">
    <div class="page-header">
      <h1>Iniciar Sesión</h1>
    </div>
    
    <s:form action="authenticate" method="post">
      <fieldset>
        <div class="clearfix">
          <label for="movimiento">Usuario</label>
          <div class="input">
          		<s:textfield cssClass="xlarge" name="usuario.login"></s:textfield>
          </div>
        </div>
        <div class="clearfix">
          <label for="movimiento">Contraseña</label>
          <div class="input">
          		<s:password cssClass="xlarge" name="usuario.password"></s:password>
          </div>
        </div>
      <div class="actions">
        <input type="submit" class="btn primary" value="Ingresar" data-backdrop="static">&nbsp;<button type="reset" class="btn">Limpiar</button>
      </div>
      </fieldset>
    </s:form>
    
    <s:actionerror/>
    
    <div id="pop-modal"></div>
    <div id="pop-over"></div>
  </div>
</div>