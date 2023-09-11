package com.hyperbank.interests.interestratevariable.entity;

import java.util.ArrayList;
import java.util.List;

import com.hyperbank.interests.interestrate.entity.InterestRate;
import com.hyperbank.interests.interestratevariablehistory.entity.InterestRateVariableHistory;
import com.paulmarcelinbejan.toolbox.utils.time.DateUtils;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "interest_rate_variable")
public class InterestRateVariable {

	@Id
	@Column(name = "id_interest_rate", nullable = false)
	private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "id_interest_rate")
    @MapsId
	private InterestRate interestRate;
	
	@OneToMany(
	    mappedBy = "interestRateVariable",
	    cascade = CascadeType.ALL,
	    orphanRemoval = true
	)
	private List<InterestRateVariableHistory> interestRateVariableHistoryList = new ArrayList<>();
	
	public InterestRateVariable addinterestRateHistory(InterestRateVariableHistory interestRateVariableHistory) {
		if(!interestRateVariableHistoryList.isEmpty()) {
			InterestRateVariableHistory lastValidInterestRate = interestRateVariableHistoryList.get(interestRateVariableHistoryList.size() - 1);
			lastValidInterestRate.setEndDate(DateUtils.lastDayOfPreviousMonth(interestRateVariableHistory.getStartDate()));
		}
		interestRateVariableHistoryList.add(interestRateVariableHistory);
		interestRateVariableHistory.setInterestRateVariable(this);
        return this;
    }
    
}