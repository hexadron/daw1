require 'spec_helper.rb'

feature 'InicioSesion' do

  scenario 'El usuario inicia sesion' do
    visit 'Aplicacion_06_inicio'
    click_on 'English'
    page.should have_content 'Welcome'
  end

end
