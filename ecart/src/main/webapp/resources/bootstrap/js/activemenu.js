$(function(){
	switch (menu) {
	case 'about':
		$('#about').addClass('active');
		break;
	case 'services':
		$('#services').addClass('active');
		break;
	case 'contact':
		$('#contact').addClass('active');
		break;
	case 'Manage Products':
		$('#manageProducts').addClass('active');
		break;

	default:
		$('#a_'+menu).addClass('active');
		$('#home').addClass('active');
		break;
	}
	
});