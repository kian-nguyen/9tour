package xyz.nhatbao.ninetour.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Date;
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
public class BillResponseModel extends BaseResponseModel<BillResponseModel> {
    private String tourName;
    private String codeOfTrip;
    private Date departureTimeOfTrip;
    private Double adultPrice;
    private Integer adultQuantity;
    private Double childPrice;
    private Integer childQuantity;
    private Double infantPrice;
    private Integer infantQuantity;

    private TripResponseModel tripResponseModel;

    private Long tripId;

    private List<ExtraBillResponseModel> extraBillResponseModels = new ArrayList<>();

    private List<PaymentLogResponseModel> paymentLogResponseModels = new ArrayList<>();

    private TicketResponseModel ticketResponseModel;

    private Long ticketId;


    private List<RefundResponse> refundResponses = new ArrayList<>();


    public Double getCost() {
        return adultPrice * adultQuantity + childPrice * childQuantity + infantPrice * infantQuantity + getExtraCost();
    }

    public Double getAdultCost() {
        return adultPrice * adultQuantity;
    }

    public Double getChildCost() {
        return childPrice * childQuantity;
    }

    public Double getInfantCost() {
        return infantPrice * infantQuantity;
    }

    public Double getBillCost() {
        return adultPrice * adultQuantity + childPrice * childQuantity + infantPrice * infantQuantity;
    }

    public Double getExtraCost() {
        double extraCost = 0.0;
        for (ExtraBillResponseModel extraBill :
                extraBillResponseModels) {
            extraCost += extraBill.getPrice() * extraBill.getQuantity();
        }
        return extraCost;
    }

    public Byte getPaymentStatusCode() {
        double cost = 0;
        byte statusCode = -1;
        if (paymentLogResponseModels.size() > 0) {
            for (PaymentLogResponseModel payment :
                    paymentLogResponseModels) {
                cost += payment.getAmount();
            }
        }
        if (cost > 0 && cost < getCost()) statusCode = 0;
        if (cost >= getCost()) statusCode = 1;
        return statusCode;
    }

    public String getPaymentStatus() {
        byte statusCode = getPaymentStatusCode();
        String status = null;
        if (statusCode == -1) status = "Ch??a thanh to??n";
        else if (statusCode == 0) status = "Ch??a ho??n t???t";
        else if (statusCode == 1) status = "???? thanh to??n";
        return status;
    }

    public Byte getRefundCode() {
        byte statusCode = -1;
        if (refundResponses.size() > 0) {
            for (RefundResponse refund : refundResponses) {
                switch (refund.getStatus()) {
                    case "waiting":
                        statusCode = 0;
                        break;
                    case "pending":
                        statusCode = 1;
                        break;
                    case "refunded":
                        statusCode = 2;
                        break;
                }
            }
        }
        return statusCode;
    }

    public String getStatus() {
        byte statusCode = getPaymentStatusCode();
        byte refundCode = getRefundCode();
        Date now = new Date();
        String status = null;
        if (refundCode != -1) {
            if (refundCode == 0) status = "???? y??u c???u h???y";
            else if (refundCode == 1) status = "H???y th??nh c??ng, ch??? ho??n ti???n";
            else if (refundCode == 2) status = "???? h???y v?? ho??n ti???n";
        } else {
            if (statusCode == -1) status = "Ch??a thanh to??n";
            else if (statusCode == 0) status = "Ch??a ho??n t???t";
            else if (statusCode == 1 && this.tripResponseModel.getDepartureTime().compareTo(now) > 0)
                status = "Ch??a kh???i h??nh";
            else if (statusCode == 1 && this.tripResponseModel.getDepartureTime().compareTo(now) <= 0)
                status = "???? kh???i h??nh";
        }
        return status;
    }


    public String getPaymentTransactionCode() {
        String code = null;
        if (paymentLogResponseModels.size() > 0) {
            code = paymentLogResponseModels.get(0).getTransactionNumber();
        }
        return code;
    }

    public Double getNeedPayCost() {
        double cost = 0;
        if (paymentLogResponseModels.size() > 0) {
            for (PaymentLogResponseModel payment :
                    paymentLogResponseModels) {
                cost += payment.getAmount();
            }
        }
        return getCost() - cost;
    }

    public Integer getTotalPassenger() {
        return adultQuantity + childQuantity + infantQuantity;
    }

    private Double totalPrice;

    private String descriptionPayment;
}
