service {
  name = "web"
  port = 84
  check {
    args = ["curl", "localhost"]
    interval = "3s"
  }
}