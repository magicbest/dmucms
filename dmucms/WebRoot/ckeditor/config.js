/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	config.filebrowserBrowseUrl = '../ckfinder/ckfinder.html';  
	  config.filebrowserImageBrowseUrl = '../ckfinder/ckfinder.html?type=Images';  
	  config.filebrowserFlashBrowseUrl = '../ckfinder/ckfinder.html?type=Flash';  
	  config.filebrowserUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files'; 
	  config.filebrowserImageUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images'; 
	  config.filebrowserFlashUploadUrl = '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash' ;
	  config.language = "zh-cn";
	  config.image_previewText=' '; //预览区域显示内容
	  config.height='500';
	config.toolbar = 'Full'
    config.toolbar_Full =
		  [
		      ['Maximize'],
		      ['Preview'],
		      
		     
		      ['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
		      
		      ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
		      
		      ['Image','Table','SpecialChar'],
		      
		      ['Font','FontSize'],
		      ['TextColor','BGColor'],
		      ['Undo','Redo','-','Find','Replace','-']
		     
		  ];

		 config.toolbar_Basic =
		  [
		      ['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink','-','About']
		  ];
};
