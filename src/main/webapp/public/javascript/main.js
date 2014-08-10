var lbm = {};
var contentContainerElement;

lbm.RegionManager = function (options) {
			
    var currentView;
    var template = Handlebars.compile($("#content-container-template").html());
    var el = options.el;
    var region = {};

    var closeView = function (view) {
        if (view) {
            view.close();
        }
    };

    var openView = function (view) {
    	el.append(template());
    	contentContainerElement = $(".content-container");
        view.setElement(contentContainerElement);
        view.render();
    };

    region.show = function (view) {
        closeView(currentView);
        currentView = view;
        openView(currentView);
    };

    return region;
};

Backbone.View.prototype.close = function(){
  this.remove();
  this.unbind();
};
