package xyz.nhatbao.ninetour.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/*******************************************************************************
 <pre>

 Copyright (c) 2021 Nguyen Nhat Bao
 This project is licensed under the terms of the MIT license.

 Author: Nguyen Nhat Bao (Kian Nguyen)
 Website: https://kiandev.xyz
 Contact for work: kiannguyen.work@gmail.com
 Feedback to me: kiannguyen.dev@gmail.com
 Github: https://github.com/kian-nguyen

 Please do not remove.

 </pre>
 ******************************************************************************/

@EqualsAndHashCode(callSuper = true)
@Data
public class PlaceRequestModel extends BaseRequestModel<PlaceRequestModel> {
    private String name;
    private String shortDescription;
    private String thumbnailUrl;
    private String description;
    private String lat;
    private String lng;
    private String pt;
    private String hd;


    private Long region;

    private Long parentPlace;

    private List<Long> childPlaces = new ArrayList<>();

    private List<Long> tours = new ArrayList<>();

    public MultipartFile imageFile;

}
