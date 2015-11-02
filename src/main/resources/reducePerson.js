function (key, values) {
    var sum = 0;
    for (var i = 0; i < values.length; i++)
        sum += values[i];
    if(values.length > 0){
    	return sum/values.length;
    }else{
    	return 0;
    }
    
}