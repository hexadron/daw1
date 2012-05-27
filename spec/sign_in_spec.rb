# encoding: UTF-8
require_relative 'support/spec_helper'

feature 'InicioSesion' do

  scenario 'El usuario ingresa con sus credenciales' do
    visit 'login'
    fill_in 'User', with: 'john'
    fill_in 'Password', with: 'shepard'
    click_on 'Log in'
    page.should have_content 'Welcome'
  end

  scenario 'El usuario selecciona un idioma' do
    visit 'i18n'
    click_on 'English'
    page.should have_content 'Welcome'
    visit 'i18n'
    click_on 'Spanish'
    page.should have_content 'Bienvenido'
  end

end
