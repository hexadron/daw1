require 'capybara/poltergeist'

# Capybara.javascript_driver = :poltergeist
Capybara.configure do |config|
  config.javascript_driver = :poltergeist
  config.current_driver = :poltergeist
  config.run_server = false
end