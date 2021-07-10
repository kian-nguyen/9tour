package xyz.nhatbao.ninetour.service;

import xyz.nhatbao.ninetour.model.request.BookingRequestModel;
import xyz.nhatbao.ninetour.model.response.BillResponseModel;

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

public interface AdminBookingService {
    BillResponseModel order(BookingRequestModel bookingRequestModel);

    BillResponseModel update(Long id, BookingRequestModel bookingRequestModel);
}
