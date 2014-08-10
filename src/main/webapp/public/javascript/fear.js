(function() {
	
	var regionManager = new lbm.RegionManager({el: $(".container")})
	
	var Router = Backbone.Router.extend({
	    routes: {
	    	"": "showCountries"
	    },
	    
	    showCountries: function(){
	    	regionManager.show(new CountryContainerView());
	    }
	});
        
        var CountryModel = Backbone.Model.extend({
            idAttribute: "id"	
	});
	
	var CountryCollection = Backbone.Collection.extend({
            url : "/api/country",
            model : CountryModel
	});
        
        var CountryRowView = Backbone.View.extend({
            tagName: "tr",
            template : Handlebars.compile($("#country-row-template").html()),
            events: {
                "click #trash" : "deleteCountry"
            },
            
            deleteCountry : function(event) {
                this.model.destroy({wait: true});
                this.remove();
            },
                
            render : function() {
                this.$el.html(this.template(this.model.toJSON()));
                return this;
            }
        })
        
        var countryCollection = new CountryCollection();
        countryCollection.fetch({async:false});
	
	var CountryTableView = Backbone.View.extend({
		
            el: ".country-data-container",
            template : Handlebars.compile($("#country-table-template").html()),
            
            initialize: function(){
                this.listenTo(countryCollection, 'add', this.render);
                this.listenTo(countryCollection, 'remove', this.render);
            },
            
            events : {
                "click #create-button" : "createCountry"
            },
            
            createCountry: function(){
                var createView = new CreateCountryView({collection: countryCollection});
                createView.render();
            },

            render: function(){
                this.$el.html(this.template());
                this.collection.each(function(country) {
                    var countryView = new CountryRowView({model: country});
                    this.$("#country-table-body").append(countryView.render().el);
                });
                this.initCountryGrid();
                return this;
            },

            initCountryGrid: function(){
                $('#country-table').footable();
            }
	});
        
        // Create Country model view
	var CreateCountryView = Backbone.View.extend({
            tagName: "div",
            model: CountryModel,

            events : {
                "click #add-button" : "submitRequest",
                "click #cancel-button" : "closeModal"
            },

            template : Handlebars.compile($("#create-template").html()),

            render : function() {
                this.$el.html(this.template());
                contentContainerElement.append(this.$el);
                $("#create-modal").modal();
                $('#create-modal').on('hidden.bs.modal',{view: this}, this.closeView);
                return this;
            },

            submitRequest : function(event) {
                var model = new CountryModel();
                model.set("name", this.$("#name").val());
                model.set("population", parseInt(this.$("#population").val()));
                model.set("gdp", parseInt(this.$("#gdp").val()));
                model.set("aggression", parseInt(this.$("#aggression").val()));
                var continent = this.$("#continent option:selected");
                model.set("continent", {id : parseInt(continent.val()), name: continent.html()});
                this.collection.create(model, {wait: true});
                this.collection.fetch({async:false})
                this.closeModal(event);
            },

            closeModal : function(event) {
                $("#create-modal").modal("hide");
            },

            closeView: function(event){
                event.data.view.close();
            }

	});
        
        // ******************** Continent view ********************************
        
        var ContinentModel = Backbone.Model.extend({

	});
	
	var ContinentCollection = Backbone.Collection.extend({
            url : "/api/continent",
            model : ContinentModel
	});
        
        var ContinentRowView = Backbone.View.extend({
            tagName: "tr",
            template : Handlebars.compile($("#continent-row-template").html()),
                
            render : function() {
                this.$el.html(this.template(this.model.toJSON()));
                return this;
            }
        })
        
        var continentCollection = new ContinentCollection();
	
	var ContinentTableView = Backbone.View.extend({
		
            el: ".continent-data-container",
            template : Handlebars.compile($("#continent-table-template").html()),
            
            initialize: function(){
                this.listenTo(countryCollection, 'add', this.render);
                this.listenTo(countryCollection, 'remove', this.render);
            },

            render: function(){
                continentCollection.fetch({async:false});
                this.$el.html(this.template());
                this.collection.each(function(continent) {
                    var continentView = new ContinentRowView({model: continent});
                    this.$("#continent-table-body").append(continentView.render().el);
                });
                this.initCountryGrid();
                return this;
            },

            initCountryGrid: function(){
                $('#continent-table').footable();
            }
	});
        
	
	// Uber View
	var CountryContainerView = Backbone.View.extend({
		
            tagName: "div",

            template : Handlebars.compile($("#country-container-template").html()),

            render: function(){
                this.$el.html(this.template());
                var tableView = new CountryTableView({collection: countryCollection});
                tableView.render();
                var continentView = new ContinentTableView({collection: continentCollection});
                continentView.render();
            }
	});
	
	/*
	 * -------------------------------------------------------------------------
	 */
	
	var router = new Router();
	Backbone.history.start();
	
})(jQuery);
