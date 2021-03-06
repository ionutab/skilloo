/**
 * Created by ionutab on 9/13/2014.
 */
var SkilloAdvancedSearch = (function(){

    var cfgDefault = {},
        initiateClass = 'advancedSearchSelect2Input',
        elementsID = "qualificationsSet",
        initiateID = null,
        maxInputs = 4,
        currentNrInputs = 0,
        currentMaxInputID = 0,
        ajaxQualificationsQueryURL = null,
        ajaxWidgetURL = null,
        select2InputSelector = "input[type=hidden][class="+initiateClass+"]",
        duplicableSelector = "div.duplicable",
        duplicatorSelector = "button.duplicator",
        initValues = {};

    var cfg = cfgDefault;

    var init = function(params){

        cfg.init = cfgDefault || {};

        cfg.initiateClass = params.initiateClass || initiateClass;
        cfg.elementsID = params.elementsID || elementsID;
        cfg.initiateID = params.initiateID || initiateID;
        cfg.maxInputs = params.maxInputs || maxInputs;
        cfg.currentNrInputs = params.currentNrInputs || currentNrInputs;
        cfg.currentMaxInputID = cfg.currentNrInputs || currentMaxInputID;
        cfg.ajaxQualificationsQueryURL = params.ajaxQualificationsQueryURL || ajaxQualificationsQueryURL;
        cfg.ajaxWidgetURL = params.ajaxWidgetURL || ajaxWidgetURL;
        cfg.select2InputSelector = params.select2InputSelector || select2InputSelector;
        cfg.duplicableSelector = params.duplicableSelector || duplicableSelector;
        cfg.duplicatorSelector = params.duplicatorSelector || duplicatorSelector;
        cfg.initValues = params.initValues || initValues;

        console.log(cfg);

        initAllInputs();
    }

    var calculateCurrentInputs = function(){
        return $("." + cfg.initiateClass).size();
    }

    var initAllInputs = function(){
        SkilloSelect2MultipleQulificationInitiator.init(cfg.ajaxQualificationsQueryURL);
        $(cfg.select2InputSelector).each(function(index){
            var elemID = cfg.elementsID + index;
            $(this).attr("id", elemID);

            if(cfg.initValues[index]){
                SkilloSelect2MultipleQulificationInitiator.select2onID("#" + elemID, cfg.initValues[index]);
            } else {
                SkilloSelect2MultipleQulificationInitiator.select2onID("#" + elemID);
            }

            cfg.currentNrInputs++;
        });
        cfg.currentMaxInputID = cfg.currentNrInputs;
    }

    var showCurrentInputs = function(){
        $(cfg.select2InputSelector).each(function(index){
            console.log( index + ": " + cfg.elementsID + index );
        });
    };

    var showCurrentDuplicableDivs = function(){
        console.log( "SIZE: " + $(".duplicable").size());
    };

    var addQualificationSelect2Widget = function(event){
        event.preventDefault();
        console.log("addQualificationSelect2Widget")
        if(cfg.currentNrInputs < cfg.maxInputs){
            $.get( cfg.ajaxWidgetURL , function( data ) {

                var htmlData = $.parseHTML( data);
                var elemID = cfg.elementsID + cfg.currentMaxInputID;
                $(htmlData[0]).find(cfg.select2InputSelector).attr("id", elemID);
                $(cfg.initiateID).append(htmlData[0]);

                SkilloSelect2MultipleQulificationInitiator.select2onID("#" + elemID);

                cfg.currentNrInputs++;
                cfg.currentMaxInputID++;

                if(cfg.currentNrInputs >= cfg.maxInputs){
                    console.log($(cfg.duplicatorSelector).length !== 0);
                    console.log($(cfg.duplicatorSelector));
                    if(cfg.duplicableSelector.length !== 0){
                        $(cfg.duplicatorSelector).hide();
                    }
                };
            });
        }
        showCurrentDuplicableDivs();
    };

    var closeQualificationSelect2Widget = function(element){
        console.log("CLOSING: " + element);
        console.log("CLOSEST: " + $(element).closest(".duplicable"));
        $(element).closest(".duplicable").remove();
        cfg.currentNrInputs--;
        if(cfg.currentNrInputs < cfg.maxInputs){
            $(cfg.duplicatorSelector).show();
        };
    };

    var initSelect2OnId = function(itemID){
        SkilloSelect2MultipleQulificationInitiator.init(cfg.ajaxQualificationsQueryURL);
        SkilloSelect2MultipleQulificationInitiator.select2onID(itemID);
    };

    var assocSelect2OnClass = function(){

    };

    return {
        showCurrentInputs:showCurrentInputs,
        initAllInputs:initAllInputs,
        init:init,
        addQualificationSelect2Widget:addQualificationSelect2Widget,
        closeQualificationSelect2Widget:closeQualificationSelect2Widget
    }


})();
