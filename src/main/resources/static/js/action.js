$(document).ready(function(){
	$(".btnDelete").click(function(){
	
	if(confirm("are you sure you want to delete?"))
	{
		
	}
	else {
		return false;
	}
	})
})

$("#Delrows").click(function(){
     	$("table tbody").find('input[name="chkbox"]').each(function(){
     		if($(this).is(":checked"))
     		{
     			$(this).parents("tr").remove();
     		}
     	});	
});

