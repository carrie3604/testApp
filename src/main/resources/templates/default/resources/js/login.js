document.addEventListener("DOMContentLoaded", function(){
	
	var appElementID = 'loginForm'
	if(!document.getElementById(appElementID)){
		return;  
	}
	//Vue.js 的實體物件
	window.testApp = new Vue({ 
			
			el:'#' + appElementID,
			delimiters: [ '[', ']'], //Vue-Variablem mit eckige Klammern benutzen
			data: {
				twd: 1,
				euro:0.278
    		},
			computed:{
				
			},
    		methods:{
				twd2jpy () {
					this.jpy = Number.parseFloat(Number(this.twd) / 0.278).toFixed(3);
				},
				jpy2twd () {
					this.twd = Number.parseFloat(Number(this.jpy) * 0.278).toFixed(3);
				},
			} 
		});
 }
 
)

