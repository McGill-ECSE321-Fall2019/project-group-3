  export default {
	  name: 'Login',
    data() {
      return {
        form: {
          email: '',
          password: ''
        }
      }
    },
    methods: {
		login() {
                if(this.form.email != "" && this.form.password != "") {
                    if(this.form.email == this.$parent.mockAccount.username && this.form.password == this.$parent.mockAccount.password) {
                        this.$emit("authenticated", true);
                        this.$router.replace({ name: "homepage" });
                    } else {
                        console.log("The username and / or password is incorrect");
                    }
                } else {
                    console.log("A username and password must be present");
				}
			},
      onSubmit(evt) {
        evt.preventDefault()
		alert(JSON.stringify(this.form))
		
      }
    }
  }

            