/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package kz.onggar.collector.openapi.api;

import kz.onggar.collector.openapi.dto.Match;
import kz.onggar.collector.openapi.dto.MatchResult;
import java.util.UUID;
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
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-10-02T22:38:59.113612700+06:00[Asia/Almaty]")
@Validated
@Api(value = "matches", description = "the matches API")
public interface MatchesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /matches
     * Return all matches
     *
     * @return Successfully returned a list of matches (status code 200)
     */
    @ApiOperation(value = "", nickname = "getAllMatches", notes = "Return all matches", response = Match.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully returned a list of matches", response = Match.class, responseContainer = "List") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/matches",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Match>> getAllMatches() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"id\" : \"046b6c7f-0b8a-43b9-b35d-6489e6daee91\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * POST /matches
     * Save match results
     *
     * @param matchResult  (required)
     * @return Successfully saved match results (status code 200)
     */
    @ApiOperation(value = "", nickname = "saveMatchResults", notes = "Save match results", response = UUID.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successfully saved match results", response = UUID.class) })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/matches",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<UUID> saveMatchResults(@ApiParam(value = "" ,required=true )  @Valid @RequestBody MatchResult matchResult) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
