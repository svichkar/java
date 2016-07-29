/**
 * Created by konstantin on 7/22/2016.
 */

require.config({
   paths: {
       jquery: 'libs/jquery/jquery-3.1.0.min',
       backbone: 'libs/backbone/backbone-min',
       require: 'libs/require/require',
       underscore: 'libs/underscore/underscore-min',
       text: 'libs/jquery/text',
       tbone: 'libs/tbone/tbone-2.0.0.min',
       dust: 'libs/dust/dust-full.min',
       dust_helper: 'libs/dust/dust-helpers.min'
   }
});

require(['views/app'], function (AppView) {
   var AppView = new AppView();
});