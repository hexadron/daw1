require 'spec_helper'

feature 'Sesiones' do

  scenario 'El usuario inicia una sesion' do
    visit 'http://localhost:8080/Aplicacion_06_inicio'
    click_on 'English'
    page.should have_content 'Welcome'
  end

end
