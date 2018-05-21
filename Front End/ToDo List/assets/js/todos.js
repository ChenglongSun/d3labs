
//click off todo
$("ul").on("click", "li", function(){
	$(this).toggleClass("completed");	
});

//click x to delete
$("ul").on("click", "span", function(){
	$(this).parent().fadeOut(500, function(){
		$(this).remove();
	});
	event.stopPropagration();
});

$("input[type = 'text']").keypress(function(event){
	if (event.which === 13) {
		//grabbing new to do task
		var toDoText = $(this).val();
		//create a new li
		$(this).val("");
		$("ul").append("<li><span><i class='fa fa-trash'></i></span> " + toDoText + "</li>");
	}
});

$(".fa-plus").click(function(){
	$("input[type = 'text']").fadeToggle();
});