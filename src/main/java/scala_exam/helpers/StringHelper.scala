package scala_exam.helpers

object StringHelper {
  implicit class StringExtension(string: String) {
    def isValidPhoneNumber: Boolean = {
      val phoneRegex = """^(\d{3}[-])(\d{4}[-])\d{2}$|^(\+\d{1,3}( )?)?((\(\d{3}\))|\d{3})[- .]?\d{3}[- .]?\d{4}$"""
      string.matches(phoneRegex)
    }

    def isValidEmail: Boolean = {
      val emailRegex = """^[a-zA-Z0-9\.!#$%&'+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)$"""
      string.matches(emailRegex)
    }
  }
}
