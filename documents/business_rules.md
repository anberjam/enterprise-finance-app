# **Purpose**
_This document defines the business rules for handling Accounts Payable (AP) and Accounts Receivable (AR) in the system. Rules are written in plain English with supporting pseudo-code to guide implementation._

## **1. Invoice Lifecycle**
Rule: All invoices must progress through lifecycle statuses.

AP: Vendors submit invoices → company pays vendors.
AR: Customers receive invoices → company collects payments.

Statuses:
        DRAFT → PENDING_APPROVAL → APPROVED → PAID
        PARTIALLY_PAID (if balance remains)
        OVERDUE (if past due and not paid)

`if invoice.total_paid == 0:
status = "APPROVED"
elif 0 < invoice.remaining_balance < invoice.total_amount:
status = "PARTIALLY_PAID"
elif invoice.remaining_balance == 0:
status = "PAID"
if today > invoice.due_date and status != "PAID":
status = "OVERDUE"`

## **2. Overdue Detection**
Rule: An invoice is overdue if the due date < today and it is not fully paid.
Optional: Add a grace period (e.g., 5 days).

`if today > invoice.due_date + grace_period and invoice.status != "PAID":
invoice.status = "OVERDUE"`

## **3. Partial Payments**
Rule: Customers or the company may pay invoices in installments.
      Each payment reduces the remaining balance.
      Invoice marked PARTIALLY_PAID until balance = 0.

`invoice.remaining_balance = invoice.total_amount - sum(invoice.payments)
if invoice.remaining_balance > 0:
invoice.status = "PARTIALLY_PAID"
else:
invoice.status = "PAID"`

## **4. Approval Thresholds**
AP Rule: High-value vendor invoices require manager approval.
AR Rule: Credit limits must not be exceeded without approval.

`if invoice.amount > approval_limit[user.role]:
invoice.status = "PENDING_APPROVAL"`

## **5. Early Payment Discounts (AR Focus)**
Rule: If customer pays within discount period, apply discount.
        Example: “2/10, net 30” → 2% discount if paid within 10 days.

`if payment.date <= invoice.issue_date + 10 days:
payment.amount = invoice.total_amount * 0.98`

## **6. Aging Buckets**
Rule: Overdue invoices categorized into standard buckets:
        0–30 days, 31–60, 61–90, >90
      Used for dashboards and KPIs (DSO, DPO).

`days_overdue = today - invoice.due_date
if 0 <= days_overdue <= 30: bucket = "0–30"
elif 31 <= days_overdue <= 60: bucket = "31–60"
elif 61 <= days_overdue <= 90: bucket = "61–90"
else: bucket = "90+"`

## **7. Duplicate Invoice Detection (AP Focus)**
Rule: Prevent duplicate entries for same Vendor + Invoice # + Amount.

`if exists(invoice.vendor_id, invoice.number, invoice.amount):
flag "DUPLICATE"`

## **8. Currency Conversion**
Rule: Store both invoice currency and converted base currency (USD).
        Conversion pulled from API on creation date.

`invoice.converted_amount = invoice.amount * fx_rate[invoice.currency][base_currency]`

## **9. Overpayment & Underpayment (AR Focus)**
Overpayment: Create customer credit balance.
Underpayment: Keep invoice open with partial status.

`if payment.amount > invoice.remaining_balance:
credit = payment.amount - invoice.remaining_balance
invoice.remaining_balance = 0
invoice.status = "PAID"
elif payment.amount < invoice.remaining_balance:
invoice.remaining_balance -= payment.amount
invoice.status = "PARTIALLY_PAID"`