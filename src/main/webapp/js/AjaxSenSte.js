
function AjaxSenSte(id){
	var result = {};
	var param = $("#"+id).serializeArray();
	for ( var i in param) {
		var name = param[i]["name"];
		var value = param[i]["value"];
		if(result[name]){
			result[name] += ","+value; 
		}else{
			result[name] = value;
		}
	}
	return result;
} 
