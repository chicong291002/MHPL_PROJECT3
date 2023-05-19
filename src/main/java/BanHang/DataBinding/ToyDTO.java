package BanHang.DataBinding;

public class ToyDTO {
	 private String keyword;
	    private Integer catId;
	    private String sort;

	    public String getKeyword() {
	        return keyword;
	    }

	    public Integer getCatId() {
	        return catId;
	    }

	    public String getSort() {
	        return sort;
	    }

	    public void setKeyword(String keyword) {
	        this.keyword = keyword;
	    }

	    public void setCatId(Integer catid) {
	        this.catId = catid;
	    }

	    public void setSort(String sort) {
	        this.sort = sort;
	    }
}
