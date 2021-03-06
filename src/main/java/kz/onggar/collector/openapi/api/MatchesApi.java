/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package kz.onggar.collector.openapi.api;

import kz.onggar.collector.openapi.dto.MatchStart;
import kz.onggar.collector.openapi.dto.MatchUpdate;
import kz.onggar.collector.openapi.dto.SteamIds;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Validated
@Api(value = "matches", description = "the matches API")
public interface MatchesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /matches
     * save info about started match
     *
     * @param steamIds  (required)
     * @return match start info saved (status code 200)
     */
    @ApiOperation(value = "", nickname = "saveMatch", notes = "save info about started match", response = MatchStart.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "match start info saved", response = MatchStart.class) })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/matches",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<MatchStart> saveMatch(@ApiParam(value = "" ,required=true )  @Valid @RequestBody SteamIds steamIds) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"match\" : { \"currentWave\" : 0, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, \"Users\" : [ { \"steamId\" : \"steamId\", \"simpleMmr\" : 6, \"settings\" : [ { \"name\" : \"name\", \"value\" : 5 }, { \"name\" : \"name\", \"value\" : 5 } ], \"competitiveMmr\" : 1, \"npcAbilitySets\" : [ { \"npcName\" : \"npcName\", \"options\" : [ 2, 2 ] }, { \"npcName\" : \"npcName\", \"options\" : [ 2, 2 ] } ], \"relativeMmr\" : 5, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }, { \"steamId\" : \"steamId\", \"simpleMmr\" : 6, \"settings\" : [ { \"name\" : \"name\", \"value\" : 5 }, { \"name\" : \"name\", \"value\" : 5 } ], \"competitiveMmr\" : 1, \"npcAbilitySets\" : [ { \"npcName\" : \"npcName\", \"options\" : [ 2, 2 ] }, { \"npcName\" : \"npcName\", \"options\" : [ 2, 2 ] } ], \"relativeMmr\" : 5, \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /matches
     * update info about started match
     *
     * @param matchUpdate  (required)
     * @return match update info saved (status code 200)
     */
    @ApiOperation(value = "", nickname = "updateMatch", notes = "update info about started match", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "match update info saved") })
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/matches",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> updateMatch(@ApiParam(value = "" ,required=true )  @Valid @RequestBody MatchUpdate matchUpdate) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
