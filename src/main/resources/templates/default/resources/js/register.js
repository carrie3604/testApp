document.addEventListener("DOMContentLoaded", function(){
	Vue.use(window.vuelidate.default);
	const { and, required, requiredIf, requiredUnless, minLength, maxLength, sameAs, email, minValue, maxValue } = window.validators;
	var appElementID = 'registerForm'
	if(!document.getElementById(appElementID)){
		return;  
	}
	//Vue.js 的實體物件
	window.testApp = new Vue({ 
			
			el:'#' + appElementID,
			delimiters: [ '[', ']'], //Vue-Variablem mit eckige Klammern benutzen
			data: {
                form: {
                    email:'',
				    password:'',
                    repeatPassword:''
                }	
    		},
			validations() {
				return {
                    form:{
                        email: {
                            required,
                        },
                        password: {
                            required,
                        },
                        repeatPassword: {
                            required,
                            sameAs: sameAs(function(){ //if the repeatPassword is the same as password turn true
                              return this.form.password})                       
                        },
                    }
					
				}
			},
    		methods:{
				handleSubmit($event) {
					this.$v.$touch();
					if (this.$v.$invalid) {
						$event.preventDefault();
						$event.stopPropagation();
						return;
					}
				}
				
			} 
		});
 }
 
)