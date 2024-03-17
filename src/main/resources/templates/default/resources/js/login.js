document.addEventListener("DOMContentLoaded", function(){
	Vue.use(window.vuelidate.default);
	const { and, required, requiredIf, requiredUnless, minLength, maxLength, sameAs, email, minValue, maxValue } = window.validators;
	var appElementID = 'loginForm'
	if(!document.getElementById(appElementID)){
		return;  
	}
	//Vue.js 的實體物件
	window.testApp = new Vue({ 
			
			el:'#' + appElementID,
			delimiters: [ '[', ']'], //Vue-Variablem mit eckige Klammern benutzen
			data: {
				errors:[],
				email:'',
				password:''
				
    		},
			computed:{
				
			},
			validations() {
				return {
					email: {
						required,
					},
					password: {
						required,
					},
				
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

