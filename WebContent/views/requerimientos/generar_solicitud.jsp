<div class="topbar">
  <div class="topbar-inner">
    <div class="container-fluid">
      <a class="brand" href="/daw1">Atenci&oacute;n de Requerimientos</a>
      <ul class="nav">
        <li><a href="/daw1">Inicio</a></li>
      </ul>
    </div>
  </div>
</div>

<div class="container-fluid">
  <div class="sidebar">
    <div class="well">
      <h5>Operaciones</h5>
      <ul>
        <li><a href="generar_solicitud.html">Generar Solicitud de Requerimiento</a></li>
        <li><a href="registrar_requerimiento.html">Registrar Requerimiento</a></li>
        <li><a href="verificar_solicitud.html">Verificar Solicitud de Requerimiento</a></li>
        <li><a href="integrar_actividades.html">Integrar Actividades</a></li>
        <li><a href="asignar_actividades.html">Asignar Actividades</a></li>
        <li><a href="asignar_analistas.html">Asignar Analistas</a></li>
        <li><a href="informe_actividad.html">Generar Informe de Actividad</a></li>  
      </ul>
    </div>
  </div>
  <div class="content">
    <div class="page-header">
      <h1>Generar Solicitud de Requerimiento</h1>
    </div>
    <form>
      <h2>Datos Generales</h2>
      <fieldset>
        <div class="clearfix">
          <label for="movimiento">Descripción del requerimiento</label>
          <div class="input">
            <textarea class="input-xlarge" rows="3"></textarea>
          </div>
        </div>
        <div class="clearfix">
          <label for="demandante">Area del Negocio</label>
          <div class="input">
            <select>
              <option>Seleccione un &aacute;rea</option>
              <option>TI</option>
              <option>Ventas</option>
              <option>Marketing</option>
              <option>Atenci&oacute;n al Cliente</option>
            </select>
          </div>
        </div>
        <div class="clearfix">
          <label for="afectada">Tipo del Requerimiento</label>
          <div class="input">
            <select>
              <option>Seleccione un tipo</option>
              <option>Proyecto</option>
              <option>Migraci&oacute;n</option>
              <option>Mantenimiento Correctivo</option>
            </select>
          </div>          
        </div>
        <div class="clearfix">
          <label for="movimiento">Origen del requerimiento</label>
          <div class="input">
            <textarea class="input-xlarge" rows="3"></textarea>
          </div>
        </div>
        <div class="clearfix">
          <label for="importe">Costo Estimado (en d&oacute;lares)</label>
          <div class="input">
            <input class="xlarge" id="importe" name="importe" size="30" type="text">
          </div>
        </div>
         <div class="clearfix">
          <label for="demandante">Criticidad</label>
          <div class="input">
            <select>
              <option>Seleccione un nivel</option>
              <option>URG - Urgente</option>
            </select>
          </div>
        </div>
        <div class="clearfix">
          <label for="afectada">Riesgo</label>
          <div class="input">
            <select>
              <option>Seleccione un nivel</option>
              <option>Alto</option>
              <option>Medio</option>
              <option>Bajo</option>
            </select>
          </div>          
        </div>
      </fieldset>
      <h2>Beneficios del Proyecto</h2>
      <fieldset>
        <div class="clearfix">
          <label for="fecha">Descripción de la problemática actual</label>
          <div class="input">
            <textarea class="input-xlarge" rows="3"></textarea>
          </div>
        </div>
        <div class="clearfix">
          <label for="fecha">Justificación del requerimiento</label>
          <div class="input">
            <textarea class="input-xlarge" rows="3"></textarea>
          </div>
        </div>
        <div class="clearfix">
          <label for="fecha">Beneficios (Metas)</label>
          <div class="input">
            <textarea class="input-xlarge" rows="3"></textarea>
          </div>
        </div>
        <div class="clearfix">
          <label for="fecha">¿Cómo va a funcionar la Solución?</label>
          <div class="input">
            <textarea class="input-xlarge" rows="3"></textarea>
          </div>
        </div>
        <div class="clearfix">
          <label for="fecha">Riesgo de No realizar el proyecto</label>
          <div class="input">
            <textarea class="input-xlarge" rows="3"></textarea>
          </div>
        </div>
        <div class="clearfix">
          <label for="fecha">Monto máximo que el usuario está dispuesto a pagar</label>
          <div class="input">
            <textarea class="input-xlarge" rows="3"></textarea>
          </div>
        </div>
        
      </fieldset>
      <h2>Alcance del Proyecto</h2>
      <fieldset>
        <div class="clearfix">
          <label for="fecha">Funcionalidad requerida detallada</label>
          <div class="input">
            <textarea class="input-xlarge" rows="9"></textarea>
          </div>
        </div>
        <div class="clearfix well">
          <h3>Restricciones</h3>

          <div class="clearfix">
            <label for="fecha">Tiempo (días)</label>
            <div class="input">
              <input class="xlarge" size="30" type="text">
            </div>
          </div>

          <div class="clearfix">
            <label for="fecha">Modalidad</label>
            <div class="input">
              <select>
                <option>Seleccione una modalidad</option>
                <option>Web</option>
                <option>Escritorio</option>
                <option>Móvil</option>
              </select>
            </div> 
          </div>
           
          <div class="clearfix">
            <label for="fecha">Navegador</label>
            <div class="input">
              <textarea class="input-xlarge" rows="3"></textarea>
            </div>
          </div>

          <div class="clearfix">
            <label for="fecha">Gestor de Base de Datos</label>
            <div class="input">
              <select>
                <option>Seleccione un gestor</option>
                <option>Redis</option>
                <option>Riak</option>
                <option>MongoDB</option>
              </select>
            </div> 
          </div>

          <div class="clearfix">
            <label for="fecha">Sistema Operativo de Servidores</label>
            <div class="input">
              <textarea class="input-xlarge" rows="3"></textarea>
            </div>
          </div>

          <div class="clearfix">
            <label for="fecha">Protocolo de Transporte/Red utilizado</label>
            <div class="input">
              <input class="xlarge" size="30" type="text">
            </div>
          </div>
        </div>
         <div class="clearfix">
            <label for="fecha">Supuestos</label>
            <div class="input">
              <textarea class="input-xlarge" rows="3"></textarea>
            </div>
          </div>
      </fieldset>
      <div class="actions">
        <input type="submit" class="btn primary" value="Generar" data-controls-modal="pop-modal" data-backdrop="static">&nbsp;<button type="reset" class="btn">Limpiar</button>
      </div>
    </form>
    <div id="pop-modal"></div>
    <div id="pop-over"></div>
  </div>
</div>