$(document).ready(function() {

    $("#add-candidates-tab-button").click(function() {
        alert('duplicating');
    });

    $('html').click(function(e) {
        $('.popable').popover('hide');
    });

    $('.popable').popover({
        html : true,
        trigger: 'manual',
        content: function() {
          var $input = $( this );
          return $('#popover_content_wrapper_' + $input.attr( "id" )).html();
        }
    }).click(function(e) {
        $(this).popover('toggle');
        e.stopPropagation();
    });

});


