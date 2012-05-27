module TestHelper
  def log_in
    visit ''
    fill_in 'User', with: 'john'
    fill_in 'Password', with: 'shepard'
    click_on 'Log in'
  end
end
