Vue.component('my-clock',{
	props:[
	
	],
	template:'<h3>{{d|formatdate}}</h3>',
	filters:{
		formatdate:function(d){
				return d.getFullYear()+'-'+(d.getMonth()+1)+"-"+d.getDate()+' '+d.getHours()+':'+d.getMinutes()+':'+d.getSeconds();
		}
	},
	data: function(){
		return {
			d: new Date()
		}
	},
	methods:{
		updatetime: function (){
			this.d=new Date()
		}
	},
	mounted:function (){
		setInterval(this.updatetime,1000);
	}
});
