require 'rspec'
require 'capybara'
require 'capybara/dsl'
require 'capybara/rspec'
require 'capybara/webkit'
require_relative './test_helper'

Capybara.default_driver = :webkit
Capybara.server_port = 8080
Capybara.app_host = "http://localhost:#{Capybara.server_port}/daw1/"

RSpec.configure do |config|
  config.include Capybara::DSL
  config.include TestHelper
end
