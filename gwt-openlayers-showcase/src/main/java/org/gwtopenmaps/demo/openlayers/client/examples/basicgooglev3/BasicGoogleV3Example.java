package org.gwtopenmaps.demo.openlayers.client.examples.basicgooglev3;

import org.gwtopenmaps.demo.openlayers.client.InfoPanel;
import org.gwtopenmaps.demo.openlayers.client.examples.AbstractExample;
import org.gwtopenmaps.openlayers.client.LonLat;
import org.gwtopenmaps.openlayers.client.Map;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapWidget;
import org.gwtopenmaps.openlayers.client.Projection;
import org.gwtopenmaps.openlayers.client.control.LayerSwitcher;
import org.gwtopenmaps.openlayers.client.control.OverviewMap;
import org.gwtopenmaps.openlayers.client.control.ScaleLine;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3MapType;
import org.gwtopenmaps.openlayers.client.layer.GoogleV3Options;

import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.HTML;

public class BasicGoogleV3Example extends AbstractExample
{
   private static final Projection DEFAULT_PROJECTION = new Projection("EPSG:4326");

   /**
    * Constructor.
    * @param title The title of the example
    * @param textResource The source of the example.
    */
   public BasicGoogleV3Example(String title, TextResource textResource)
   {
      super(title, textResource);
   }

   @Override
   public void buildPanel()
   {
      //create some MapOptions
      MapOptions defaultMapOptions = new MapOptions();
      defaultMapOptions.setNumZoomLevels(16);

      //Create a MapWidget
      MapWidget mapWidget = new MapWidget("500px", "500px", defaultMapOptions);

      //Create some Google Layers
      GoogleV3Options gHybridOptions = new GoogleV3Options();
      gHybridOptions.setIsBaseLayer(true);
      gHybridOptions.setType(GoogleV3MapType.G_HYBRID_MAP);
      GoogleV3  gHybrid = new GoogleV3("Google Hybrid", gHybridOptions);

      GoogleV3Options gNormalOptions = new GoogleV3Options();
      gNormalOptions.setIsBaseLayer(true);
      gNormalOptions.setType(GoogleV3MapType.G_NORMAL_MAP);
      GoogleV3 gNormal = new GoogleV3("Google Normal", gNormalOptions);

      GoogleV3Options gSatelliteOptions = new GoogleV3Options();
      gSatelliteOptions.setIsBaseLayer(true);
      gSatelliteOptions.setType(GoogleV3MapType.G_SATELLITE_MAP);
      GoogleV3 gSatellite = new GoogleV3("Google Satellite", gSatelliteOptions);

      GoogleV3Options gTerrainOptions = new GoogleV3Options();
      gTerrainOptions.setIsBaseLayer(true);
      gTerrainOptions.setType(GoogleV3MapType.G_TERRAIN_MAP);
      GoogleV3 gTerrain = new GoogleV3("Google Terrain", gTerrainOptions);

      //And add them to the map
      Map map = mapWidget.getMap();
      map.addLayer(gHybrid);
      map.addLayer(gNormal);
      map.addLayer(gSatellite);
      map.addLayer(gTerrain);

      //Lets add some default controls to the map
      map.addControl(new LayerSwitcher()); //+ sign in the upperright corner to display the layer switcher
      map.addControl(new OverviewMap()); //+ sign in the lowerright to display the overviewmap
      map.addControl(new ScaleLine()); //Display the scaleline

      //Center and zoom to a location
      LonLat lonLat = new LonLat(6.95, 50.94);
      lonLat.transform(DEFAULT_PROJECTION.getProjectionCode() , map.getProjection()); //transform lonlat to OSM coordinate system
      map.setCenter(lonLat, 12);

      contentPanel.add(new HTML("<p>This example shows how to add Google V3 layers to GWT-OL.</p><p>If you use the Google Maps v3 API with a Google layer, you don't need to include an API key. This layer only works in the spherical mercator projection.</p><p><b>Note on Google Maps API versioning:</b> This example uses the \"nightly\" version of Google Maps API. This is specified by using v=3 in the the Google Maps API URL. Production applications should use the \"release\" or \"frozen\" versions of Google Maps API. See the OpenLayers.Layer.Google.v3 API docs, and the Versioning Section of the Google Maps API docs, for more details.</p>"));
      contentPanel.add(new InfoPanel("<p>Don't forget to add the following line to your HTML if you want to use Google V3. :</p>" +
      		"<p><b>&lt;script src=\"http://maps.google.com/maps/api/js?v=3&amp;sensor=false\"&gt;&lt;/script&gt;</b></p>"));
      contentPanel.add(mapWidget);

      initWidget(contentPanel);

      mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0); //force the map to fall behind popups
   }
}
